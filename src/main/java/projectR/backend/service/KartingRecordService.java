package projectR.backend.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectR.backend.model.KartingRecord;
import projectR.backend.repository.KartingRecordRepo;

@Service
public class KartingRecordService {
	
	@Autowired
	private KartingRecordRepo repo;
	
	/**
	 * Compares two KartingRecords based on the duration time.
	 */
	Comparator<KartingRecord> naturalOrder = new Comparator<>() {
		@Override
		public int compare(KartingRecord o1, KartingRecord o2) {
			String t1 = o1.getDuration();
			String t2 = o2.getDuration();
			return t1.compareTo(t2);
		}
	};
	
	/**
	 * Lists records with best times of each player from shortest to longest.
	 * @return list of records with best times of each player in ascending order.
	 */
	public List<KartingRecord> listAllBestTimesSorted() {
		List<KartingRecord> result = new ArrayList<>();
		
		Map<String, List<KartingRecord>> recordsByEmails = repo.findAll().stream().collect(Collectors.groupingBy(KartingRecord::getEmail));
		
		//for each player, find his best time and consider only that score for the ranking list:
		for(Map.Entry<String, List<KartingRecord>> recordsByOnePerson : recordsByEmails.entrySet()) {

			Optional<KartingRecord> optional = recordsByOnePerson.getValue().stream().min(naturalOrder);
			
			if(optional.isPresent()) {
				KartingRecord reformat = optional.get();
				reformat.setDuration(formatDurationOutput(optional.get().getDuration()));
				result.add(reformat);
			}
		}
		
		return result.stream().sorted(naturalOrder).collect(Collectors.toList());
		
	}
	
	/**
	 * Creates a new KartingRecord in the database.
	 * @return newly created KartingRecord or null if username or email are blank
	 */
	public KartingRecord createKartingRecord(KartingRecord kartingRecord) {
		if(kartingRecord.getUsername().isBlank() || kartingRecord.getEmail().isBlank()) {
			return null;
		}
		return repo.save(kartingRecord);
	}

	public String formatDurationOutput(String durationInSec) {
		Integer seconds, minutes, hours, time;
		String secondsStr, minutesStr, hoursStr;

		time = Integer.parseInt(durationInSec);
		seconds = time % 60;
		time = (time - seconds) / 60;
		minutes = time % 60;

		if (minutes < 10) {minutesStr = "0"+minutes;} else {minutesStr = minutes.toString();}
		if (seconds < 10) {secondsStr = "0"+seconds;} else {secondsStr = seconds.toString();}

		String duration =  minutesStr + ":" +secondsStr;
		return duration;
	};

}
