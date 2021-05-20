package projectR.backend.service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectR.backend.model.PlatformerRecord;
import projectR.backend.repository.PlatformerRecordRepo;

@Service
public class PlatformerRecordService {
	
	@Autowired
	private PlatformerRecordRepo repo;
	
	/**
	 * Compares two PlatformerRecords based on the duration time.
	 */
	Comparator<PlatformerRecord> naturalOrder = new Comparator<>() {
		@Override
		public int compare(PlatformerRecord o1, PlatformerRecord o2) {
			Time t1 = Time.valueOf(o1.getDuration());
			Time t2 = Time.valueOf(o2.getDuration());
			return t1.compareTo(t2);
		}

	};

	/**
	 * Lists records with best times of each player from shortest to longest.
	 * @return list of records with best times of each player in ascending order.
	 */
	public List<PlatformerRecord> listAllBestTimesSorted() {
		List<PlatformerRecord> result = new ArrayList<>();
		
		Map<String, List<PlatformerRecord>> recordsByEmails = repo.findAll().stream().collect(Collectors.groupingBy(PlatformerRecord::getEmail));
		
		//for each player, find his best time and consider only that score for the ranking list:
		for(Map.Entry<String, List<PlatformerRecord>> recordsByOnePerson : recordsByEmails.entrySet()) {
			
			Optional<PlatformerRecord> optional = recordsByOnePerson.getValue().stream().min(naturalOrder);
			
			if(optional.isPresent()) {
				result.add(optional.get());
			}
		}
		return result.stream().sorted(naturalOrder).collect(Collectors.toList());
	}
	
	/**
	 * Creates a new PlatformerRecord in the database.
	 * @return newly created PlatformerRecord or null if username or email are blank
	 */
	public PlatformerRecord createPlatformerRecord(PlatformerRecord platformerRecord) {
		if(platformerRecord.getUsername().isBlank() || platformerRecord.getEmail().isBlank() || !canBeParsedToTime(platformerRecord.getDuration())) {
			return null;
		}
		return repo.save(platformerRecord);
	}

	public static boolean canBeParsedToTime(String duration) {
		try {
			Time.valueOf(duration);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

}
