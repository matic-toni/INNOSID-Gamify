package projectR.backend.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectR.backend.model.FPSRecord;
import projectR.backend.repository.FPSRecordRepo;

@Service
public class FPSRecordService {
	
	@Autowired
	private FPSRecordRepo repo;
	
	/**
	 * Comparator for FPSRecord which considers only the score for comparing.
	 */
	private Comparator<FPSRecord> naturalOrder = (o1, o2) -> o1.getScore() - o2.getScore();
	
	/**
	 * Lists records with best scores of each player from best to worst.
	 * @return list of records with best scores of each player in descending order.
	 */
	public List<FPSRecord> listAllBestScoresSorted(){
		
		List<FPSRecord> result = new ArrayList<>();
		
		Map<String, List<FPSRecord>> recordsByEmails = repo.findAll().stream().collect(Collectors.groupingBy(FPSRecord::getEmail));
		
		//for each player, find his best score and consider only that score for the ranking list:
		for(Map.Entry<String, List<FPSRecord>> recordsByOnePerson : recordsByEmails.entrySet()) {
			
			Optional<FPSRecord> optional = recordsByOnePerson.getValue().stream().max(naturalOrder);
			
			if(optional.isPresent()) {
				result.add(optional.get());
			}
		}
		
		return result.stream().sorted(naturalOrder.reversed()).collect(Collectors.toList());
	}
	
	/**
	 * Creates a new FPSRecord in the database.
	 * @return the created FPSRecord or null if username or email is blank
	 */
	public FPSRecord createFPSRecord(FPSRecord fpsRecord) {
		if(fpsRecord.getUsername().isBlank() || fpsRecord.getEmail().isBlank() || fpsRecord.getScore() == null) {
			return null;
		}
		return repo.save(fpsRecord);
	}
	
}
