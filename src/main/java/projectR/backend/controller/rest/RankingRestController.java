package projectR.backend.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import projectR.backend.model.FPSRecord;
import projectR.backend.model.KartingRecord;
import projectR.backend.model.PlatformerRecord;
import projectR.backend.service.FPSRecordService;
import projectR.backend.service.KartingRecordService;
import projectR.backend.service.PlatformerRecordService;


@RestController
public class RankingRestController {
	
	@Autowired
	private FPSRecordService serviceFPS;
	
	@Autowired
	private PlatformerRecordService servicePlatformer;
	
	@Autowired
	private KartingRecordService serviceKarting;
	
	
	
	@GetMapping("/ranking/fps")
	public List<FPSRecord> getAllSortedFPS(){
		return serviceFPS.listAllBestScoresSorted();
	}
	
	@GetMapping("/ranking/platformer")
	public List<PlatformerRecord> getAllPlatformer(){
		return servicePlatformer.listAllBestTimesSorted();
	}
	
	@GetMapping("/ranking/karting")
	public List<KartingRecord> getAllKarting(){
		return serviceKarting.listAllBestTimesSorted();
	}
	
	
	
	@PostMapping("/ranking/fps")
	public ResponseEntity<FPSRecord> createFPSRecord(@RequestBody FPSRecord fpsRecord) {
		FPSRecord rec = serviceFPS.createFPSRecord(fpsRecord);
		
		if(rec != null) {
			return ResponseEntity.ok(rec);
		} 
		return ResponseEntity.badRequest().body(rec);
	}
	
	@PostMapping("/ranking/platformer")
	public ResponseEntity<PlatformerRecord> createKartingRecord(@RequestBody PlatformerRecord platformerRecord) {
		PlatformerRecord rec = servicePlatformer.createPlatformerRecord(platformerRecord);
		
		if(rec != null) {
			return ResponseEntity.ok(rec);
		} 
		return ResponseEntity.badRequest().body(rec);
	}
	
	@PostMapping("/ranking/karting")
	public ResponseEntity<KartingRecord> createKartingRecord(@RequestBody KartingRecord kartingRecord) {
		KartingRecord rec = serviceKarting.createKartingRecord(kartingRecord);
		
		if(rec != null) {
			return ResponseEntity.ok(rec);
		} 
		return ResponseEntity.badRequest().body(rec);
	}
	
}
