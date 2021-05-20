package projectR.backend;

import java.io.InputStream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import projectR.backend.model.App;
import projectR.backend.model.Event;
import projectR.backend.model.FPSRecord;
import projectR.backend.model.Form;
import projectR.backend.model.ImageResource;
import projectR.backend.model.KartingRecord;
import projectR.backend.model.PlatformerRecord;
import projectR.backend.model.Question;
import projectR.backend.model.Speaker;
import projectR.backend.model.Speech;
import projectR.backend.repository.*;
import projectR.backend.service.ImageService;

@SpringBootApplication
public class InnosidGamifyApplication implements CommandLineRunner {

	@Autowired
	private ImageService imageService;
	
	@Autowired
	private AppRepo appRepo;

	
	public static void main(String[] args) {
		SpringApplication.run(InnosidGamifyApplication.class, args);
	}
	
	@Transactional
	@Override
	public void run(String... args) throws Exception {

		ImageResource prskalice_1 = new ImageResource("http://161.53.19.210:8080/images/prskalice-001.png");
		ImageResource prskalice_2 = new ImageResource("http://161.53.19.210:8080/images/prskalice-002.png");
		ImageResource prskalice_3 = new ImageResource("http://161.53.19.210:8080/images/prskalice-003.png");
		ImageResource prskalice_4 = new ImageResource("http://161.53.19.210:8080/images/prskalice-004.png");
		ImageResource prskalice_5 = new ImageResource("http://161.53.19.210:8080/images/prskalice-005.png");
		ImageResource prskalice_6 = new ImageResource("http://161.53.19.210:8080/images/prskalice-006.png");
		ImageResource prskalice_7 = new ImageResource("http://161.53.19.210:8080/images/prskalice-007.png");
		ImageResource prskalice_8 = new ImageResource("http://161.53.19.210:8080/images/prskalice-008.png");

		App app1 = new App("prskalice");
		app1.getImageResources().add(prskalice_1);
		app1.getImageResources().add(prskalice_2);
		app1.getImageResources().add(prskalice_3);
		app1.getImageResources().add(prskalice_4);
		app1.getImageResources().add(prskalice_5);
		app1.getImageResources().add(prskalice_6);
		app1.getImageResources().add(prskalice_7);
		app1.getImageResources().add(prskalice_8);



		ImageResource matematicki_vrtuljak1 = new ImageResource("http://161.53.19.210:8080/images/matematicki_vrtuljak-001.png");
		ImageResource matematicki_vrtuljak2 = new ImageResource("http://161.53.19.210:8080/images/matematicki_vrtuljak-002.png");
		ImageResource matematicki_vrtuljak3 = new ImageResource("http://161.53.19.210:8080/images/matematicki_vrtuljak-003.png");
		ImageResource matematicki_vrtuljak4 = new ImageResource("http://161.53.19.210:8080/images/matematicki_vrtuljak-004.png");
		ImageResource matematicki_vrtuljak5 = new ImageResource("http://161.53.19.210:8080/images/matematicki_vrtuljak-005.png");
		ImageResource matematicki_vrtuljak6 = new ImageResource("http://161.53.19.210:8080/images/matematicki_vrtuljak-006.png");
		ImageResource matematicki_vrtuljak7 = new ImageResource("http://161.53.19.210:8080/images/matematicki_vrtuljak-007.png");
		ImageResource matematicki_vrtuljak8 = new ImageResource("http://161.53.19.210:8080/images/matematicki_vrtuljak-008.png");
		ImageResource matematicki_vrtuljak9 = new ImageResource("http://161.53.19.210:8080/images/matematicki_vrtuljak-009.png");
		ImageResource matematicki_vrtuljak10 = new ImageResource("http://161.53.19.210:8080/images/matematicki_vrtuljak-010.png");
		ImageResource matematicki_vrtuljak11= new ImageResource("http://161.53.19.210:8080/images/matematicki_vrtuljak-011.png");
		ImageResource matematicki_vrtuljak12 = new ImageResource("http://161.53.19.210:8080/images/matematicki_vrtuljak-012.png");
		ImageResource matematicki_vrtuljak13 = new ImageResource("http://161.53.19.210:8080/images/matematicki_vrtuljak-013.png");
		ImageResource matematicki_vrtuljak14 = new ImageResource("http://161.53.19.210:8080/images/matematicki_vrtuljak-014.png");


		App app2 = new App("matematicki_vrtuljak");
		app2.getImageResources().add(matematicki_vrtuljak1);
		app2.getImageResources().add(matematicki_vrtuljak2);
		app2.getImageResources().add(matematicki_vrtuljak3);
		app2.getImageResources().add(matematicki_vrtuljak4);
		app2.getImageResources().add(matematicki_vrtuljak5);
		app2.getImageResources().add(matematicki_vrtuljak6);
		app2.getImageResources().add(matematicki_vrtuljak7);
		app2.getImageResources().add(matematicki_vrtuljak8);
		app2.getImageResources().add(matematicki_vrtuljak9);
		app2.getImageResources().add(matematicki_vrtuljak10);
		app2.getImageResources().add(matematicki_vrtuljak11);
		app2.getImageResources().add(matematicki_vrtuljak12);
		app2.getImageResources().add(matematicki_vrtuljak13);
		app2.getImageResources().add(matematicki_vrtuljak14);


		ImageResource koliko_je_sati1 = new ImageResource("http://161.53.19.210:8080/images/koliko_je_sati-001.png");
		ImageResource koliko_je_sati2 = new ImageResource("http://161.53.19.210:8080/images/koliko_je_sati-002.png");
		ImageResource koliko_je_sati3 = new ImageResource("http://161.53.19.210:8080/images/koliko_je_sati-003.png");
		ImageResource koliko_je_sati4 = new ImageResource("http://161.53.19.210:8080/images/koliko_je_sati-004.png");
		ImageResource koliko_je_sati5 = new ImageResource("http://161.53.19.210:8080/images/koliko_je_sati-005.png");
		ImageResource koliko_je_sati6 = new ImageResource("http://161.53.19.210:8080/images/koliko_je_sati-006.png");
		ImageResource koliko_je_sati7 = new ImageResource("http://161.53.19.210:8080/images/koliko_je_sati-007.png");
		ImageResource koliko_je_sati8 = new ImageResource("http://161.53.19.210:8080/images/koliko_je_sati-008.png");
		ImageResource koliko_je_sati9 = new ImageResource("http://161.53.19.210:8080/images/koliko_je_sati-009.png");
		ImageResource koliko_je_sati10 = new ImageResource("http://161.53.19.210:8080/images/koliko_je_sati-010.png");


		App app3 = new App("koliko_je_sati");
		app3.getImageResources().add(koliko_je_sati1);
		app3.getImageResources().add(koliko_je_sati2);
		app3.getImageResources().add(koliko_je_sati3);
		app3.getImageResources().add(koliko_je_sati4);
		app3.getImageResources().add(koliko_je_sati5);
		app3.getImageResources().add(koliko_je_sati6);
		app3.getImageResources().add(koliko_je_sati7);
		app3.getImageResources().add(koliko_je_sati8);
		app3.getImageResources().add(koliko_je_sati9);
		app3.getImageResources().add(koliko_je_sati10);


		ImageResource matematika1 = new ImageResource("http://161.53.19.210:8080/images/matematika-001.png");
		ImageResource matematika2 = new ImageResource("http://161.53.19.210:8080/images/matematika-002.png");
		ImageResource matematika3 = new ImageResource("http://161.53.19.210:8080/images/matematika-003.png");
		ImageResource matematika4 = new ImageResource("http://161.53.19.210:8080/images/matematika-004.png");
		ImageResource matematika5 = new ImageResource("http://161.53.19.210:8080/images/matematika-005.png");
		ImageResource matematika6 = new ImageResource("http://161.53.19.210:8080/images/matematika-006.png");
		ImageResource matematika7 = new ImageResource("http://161.53.19.210:8080/images/matematika-007.png");
		ImageResource matematika8 = new ImageResource("http://161.53.19.210:8080/images/matematika-008.png");
		ImageResource matematika9 = new ImageResource("http://161.53.19.210:8080/images/matematika-009.png");


		App app4 = new App("matematika");
		app4.getImageResources().add(matematika1);
		app4.getImageResources().add(matematika2);
		app4.getImageResources().add(matematika3);
		app4.getImageResources().add(matematika4);
		app4.getImageResources().add(matematika5);
		app4.getImageResources().add(matematika6);
		app4.getImageResources().add(matematika7);
		app4.getImageResources().add(matematika8);
		app4.getImageResources().add(matematika9);


		ImageResource ucimo_boje1 = new ImageResource("http://161.53.19.210:8080/images/ucimo_boje-001.png");
		ImageResource ucimo_boje2 = new ImageResource("http://161.53.19.210:8080/images/ucimo_boje-002.png");
		ImageResource ucimo_boje3 = new ImageResource("http://161.53.19.210:8080/images/ucimo_boje-003.png");
		ImageResource ucimo_boje4 = new ImageResource("http://161.53.19.210:8080/images/ucimo_boje-004.png");
		ImageResource ucimo_boje5 = new ImageResource("http://161.53.19.210:8080/images/ucimo_boje-005.png");
		ImageResource ucimo_boje6 = new ImageResource("http://161.53.19.210:8080/images/ucimo_boje-006.png");
		ImageResource ucimo_boje7 = new ImageResource("http://161.53.19.210:8080/images/ucimo_boje-007.png");
		ImageResource ucimo_boje8 = new ImageResource("http://161.53.19.210:8080/images/ucimo_boje-008.png");
		ImageResource ucimo_boje9 = new ImageResource("http://161.53.19.210:8080/images/ucimo_boje-009.png");
		ImageResource ucimo_boje10 = new ImageResource("http://161.53.19.210:8080/images/ucimo_boje-010.png");
		ImageResource ucimo_boje11 = new ImageResource("http://161.53.19.210:8080/images/ucimo_boje-011.png");
		ImageResource ucimo_boje12 = new ImageResource("http://161.53.19.210:8080/images/ucimo_boje-012.png");

		App app5 = new App("ucimo_boje");
		app5.getImageResources().add(ucimo_boje1);
		app5.getImageResources().add(ucimo_boje2);
		app5.getImageResources().add(ucimo_boje3);
		app5.getImageResources().add(ucimo_boje4);
		app5.getImageResources().add(ucimo_boje5);
		app5.getImageResources().add(ucimo_boje6);
		app5.getImageResources().add(ucimo_boje7);
		app5.getImageResources().add(ucimo_boje8);
		app5.getImageResources().add(ucimo_boje9);
		app5.getImageResources().add(ucimo_boje10);
		app5.getImageResources().add(ucimo_boje11);
		app5.getImageResources().add(ucimo_boje12);


		this.appRepo.save(app1);
		this.appRepo.save(app2);
		this.appRepo.save(app3);
		this.appRepo.save(app4);
		this.appRepo.save(app5);


		ClassPathResource resource8 = new ClassPathResource("photos/prskalice-001.png");
		String imgName8 = resource8.getFilename();
		InputStream imgInput8 = resource8.getInputStream();
		
		ClassPathResource resource9 = new ClassPathResource("photos/prskalice-002.png");
		String imgName9 = resource9.getFilename();
		InputStream imgInput9 = resource9.getInputStream();
		
		ClassPathResource resource10 = new ClassPathResource("photos/prskalice-003.png");
		String imgName10 = resource10.getFilename();
		InputStream imgInput10 = resource10.getInputStream();

		ClassPathResource resource11 = new ClassPathResource("photos/prskalice-004.png");
		String imgName11 = resource11.getFilename();
		InputStream imgInput11 = resource11.getInputStream();

		ClassPathResource resource12 = new ClassPathResource("photos/prskalice-005.png");
		String imgName12 = resource12.getFilename();
		InputStream imgInput12 = resource12.getInputStream();

		ClassPathResource resource13 = new ClassPathResource("photos/prskalice-006.png");
		String imgName13 = resource13.getFilename();
		InputStream imgInput13 = resource13.getInputStream();

		ClassPathResource resource14 = new ClassPathResource("photos/prskalice-007.png");
		String imgName14 = resource14.getFilename();
		InputStream imgInput14 = resource14.getInputStream();

		ClassPathResource resource15 = new ClassPathResource("photos/prskalice-008.png");
		String imgName15 = resource15.getFilename();
		InputStream imgInput15 = resource15.getInputStream();

		ClassPathResource resource16 = new ClassPathResource("photos/matematika-001.png");
		String imgName16 = resource16.getFilename();
		InputStream imgInput16 = resource16.getInputStream();

		ClassPathResource resource17 = new ClassPathResource("photos/matematika-002.png");
		String imgName17 = resource17.getFilename();
		InputStream imgInput17 = resource17.getInputStream();

		ClassPathResource resource18 = new ClassPathResource("photos/matematika-003.png");
		String imgName18 = resource18.getFilename();
		InputStream imgInput18 = resource18.getInputStream();

		ClassPathResource resource19 = new ClassPathResource("photos/matematika-004.png");
		String imgName19 = resource19.getFilename();
		InputStream imgInput19 = resource19.getInputStream();

		ClassPathResource resource20 = new ClassPathResource("photos/matematika-005.png");
		String imgName20 = resource20.getFilename();
		InputStream imgInput20 = resource20.getInputStream();

		ClassPathResource resource21 = new ClassPathResource("photos/matematika-006.png");
		String imgName21 = resource21.getFilename();
		InputStream imgInput21 = resource21.getInputStream();

		ClassPathResource resource22 = new ClassPathResource("photos/matematika-007.png");
		String imgName22 = resource22.getFilename();
		InputStream imgInput22 = resource22.getInputStream();

		ClassPathResource resource23 = new ClassPathResource("photos/matematika-008.png");
		String imgName23 = resource23.getFilename();
		InputStream imgInput23 = resource23.getInputStream();

		ClassPathResource resource24 = new ClassPathResource("photos/matematika-009.png");
		String imgName24 = resource24.getFilename();
		InputStream imgInput24 = resource24.getInputStream();

		ClassPathResource resource25 = new ClassPathResource("photos/matematicki_vrtuljak-001.png");
		String imgName25 = resource25.getFilename();
		InputStream imgInput25 = resource25.getInputStream();

		ClassPathResource resource26 = new ClassPathResource("photos/matematicki_vrtuljak-002.png");
		String imgName26 = resource26.getFilename();
		InputStream imgInput26 = resource26.getInputStream();

		ClassPathResource resource27 = new ClassPathResource("photos/matematicki_vrtuljak-003.png");
		String imgName27 = resource27.getFilename();
		InputStream imgInput27 = resource27.getInputStream();

		ClassPathResource resource28 = new ClassPathResource("photos/matematicki_vrtuljak-004.png");
		String imgName28 = resource28.getFilename();
		InputStream imgInput28 = resource28.getInputStream();

		ClassPathResource resource29 = new ClassPathResource("photos/matematicki_vrtuljak-005.png");
		String imgName29 = resource29.getFilename();
		InputStream imgInput29 = resource29.getInputStream();

		ClassPathResource resource30 = new ClassPathResource("photos/matematicki_vrtuljak-006.png");
		String imgName30 = resource30.getFilename();
		InputStream imgInput30 = resource30.getInputStream();

		ClassPathResource resource31 = new ClassPathResource("photos/matematicki_vrtuljak-007.png");
		String imgName31 = resource31.getFilename();
		InputStream imgInput31 = resource31.getInputStream();

		ClassPathResource resource32 = new ClassPathResource("photos/matematicki_vrtuljak-008.png");
		String imgName32 = resource32.getFilename();
		InputStream imgInput32 = resource32.getInputStream();

		ClassPathResource resource84 = new ClassPathResource("photos/matematicki_vrtuljak-009.png");
		String imgName84 = resource84.getFilename();
		InputStream imgInput84 = resource84.getInputStream();


		ClassPathResource resource33 = new ClassPathResource("photos/matematicki_vrtuljak-010.png");
		String imgName33 = resource33.getFilename();
		InputStream imgInput33 = resource33.getInputStream();

		ClassPathResource resource34 = new ClassPathResource("photos/matematicki_vrtuljak-011.png");
		String imgName34 = resource34.getFilename();
		InputStream imgInput34 = resource34.getInputStream();

		ClassPathResource resource35 = new ClassPathResource("photos/matematicki_vrtuljak-012.png");
		String imgName35 = resource35.getFilename();
		InputStream imgInput35 = resource35.getInputStream();

		ClassPathResource resource36 = new ClassPathResource("photos/matematicki_vrtuljak-013.png");
		String imgName36 = resource36.getFilename();
		InputStream imgInput36 = resource36.getInputStream();

		ClassPathResource resource37 = new ClassPathResource("photos/matematicki_vrtuljak-014.png");
		String imgName37 = resource37.getFilename();
		InputStream imgInput37 = resource37.getInputStream();

		ClassPathResource resource38 = new ClassPathResource("photos/koliko_je_sati-001.png");
		String imgName38 = resource38.getFilename();
		InputStream imgInput38 = resource38.getInputStream();

		ClassPathResource resource39 = new ClassPathResource("photos/koliko_je_sati-002.png");
		String imgName39 = resource39.getFilename();
		InputStream imgInput39 = resource39.getInputStream();

		ClassPathResource resource40 = new ClassPathResource("photos/koliko_je_sati-003.png");
		String imgName40 = resource40.getFilename();
		InputStream imgInput40 = resource40.getInputStream();

		ClassPathResource resource41 = new ClassPathResource("photos/koliko_je_sati-004.png");
		String imgName41 = resource41.getFilename();
		InputStream imgInput41 = resource41.getInputStream();

		ClassPathResource resource42 = new ClassPathResource("photos/koliko_je_sati-005.png");
		String imgName42 = resource42.getFilename();
		InputStream imgInput42 = resource42.getInputStream();

		ClassPathResource resource43 = new ClassPathResource("photos/koliko_je_sati-006.png");
		String imgName43 = resource43.getFilename();
		InputStream imgInput43 = resource43.getInputStream();

		ClassPathResource resource44 = new ClassPathResource("photos/koliko_je_sati-007.png");
		String imgName44 = resource44.getFilename();
		InputStream imgInput44 = resource44.getInputStream();

		ClassPathResource resource45 = new ClassPathResource("photos/koliko_je_sati-008.png");
		String imgName45 = resource45.getFilename();
		InputStream imgInput45 = resource45.getInputStream();

		ClassPathResource resource46 = new ClassPathResource("photos/koliko_je_sati-009.png");
		String imgName46 = resource46.getFilename();
		InputStream imgInput46 = resource46.getInputStream();

		ClassPathResource resource47 = new ClassPathResource("photos/koliko_je_sati-010.png");
		String imgName47 = resource47.getFilename();
		InputStream imgInput47 = resource47.getInputStream();

		ClassPathResource resource48 = new ClassPathResource("photos/ucimo_boje-001.png");
		String imgName48 = resource48.getFilename();
		InputStream imgInput48 = resource48.getInputStream();

		ClassPathResource resource49 = new ClassPathResource("photos/ucimo_boje-002.png");
		String imgName49 = resource49.getFilename();
		InputStream imgInput49 = resource49.getInputStream();

		ClassPathResource resource50 = new ClassPathResource("photos/ucimo_boje-003.png");
		String imgName50 = resource50.getFilename();
		InputStream imgInput50 = resource50.getInputStream();

		ClassPathResource resource51 = new ClassPathResource("photos/ucimo_boje-004.png");
		String imgName51 = resource51.getFilename();
		InputStream imgInput51 = resource51.getInputStream();

		ClassPathResource resource52 = new ClassPathResource("photos/ucimo_boje-005.png");
		String imgName52 = resource52.getFilename();
		InputStream imgInput52 = resource52.getInputStream();

		ClassPathResource resource53 = new ClassPathResource("photos/ucimo_boje-006.png");
		String imgName53 = resource53.getFilename();
		InputStream imgInput53 = resource53.getInputStream();

		ClassPathResource resource54 = new ClassPathResource("photos/ucimo_boje-007.png");
		String imgName54 = resource54.getFilename();
		InputStream imgInput54 = resource54.getInputStream();

		ClassPathResource resource55 = new ClassPathResource("photos/ucimo_boje-008.png");
		String imgName55 = resource55.getFilename();
		InputStream imgInput55 = resource55.getInputStream();

		ClassPathResource resource56 = new ClassPathResource("photos/ucimo_boje-009.png");
		String imgName56 = resource56.getFilename();
		InputStream imgInput56 = resource56.getInputStream();

		ClassPathResource resource57 = new ClassPathResource("photos/ucimo_boje-010.png");
		String imgName57 = resource57.getFilename();
		InputStream imgInput57 = resource57.getInputStream();

		ClassPathResource resource58 = new ClassPathResource("photos/ucimo_boje-011.png");
		String imgName58 = resource58.getFilename();
		InputStream imgInput58 = resource58.getInputStream();

		ClassPathResource resource59 = new ClassPathResource("photos/ucimo_boje-012.png");
		String imgName59 = resource59.getFilename();
		InputStream imgInput59 = resource59.getInputStream();

		this.imageService.saveImageCompressed(imgName8, imgInput8.readAllBytes());
		this.imageService.saveImageCompressed(imgName9, imgInput9.readAllBytes());
		this.imageService.saveImageCompressed(imgName10, imgInput10.readAllBytes());
		this.imageService.saveImageCompressed(imgName11, imgInput11.readAllBytes());
		this.imageService.saveImageCompressed(imgName12, imgInput12.readAllBytes());
		this.imageService.saveImageCompressed(imgName13, imgInput13.readAllBytes());
		this.imageService.saveImageCompressed(imgName14, imgInput14.readAllBytes());
		this.imageService.saveImageCompressed(imgName15, imgInput15.readAllBytes());
		this.imageService.saveImageCompressed(imgName16, imgInput16.readAllBytes());
		this.imageService.saveImageCompressed(imgName17, imgInput17.readAllBytes());
		this.imageService.saveImageCompressed(imgName18, imgInput18.readAllBytes());
		this.imageService.saveImageCompressed(imgName19, imgInput19.readAllBytes());
		this.imageService.saveImageCompressed(imgName20, imgInput20.readAllBytes());
		this.imageService.saveImageCompressed(imgName21, imgInput21.readAllBytes());
		this.imageService.saveImageCompressed(imgName22, imgInput22.readAllBytes());
		this.imageService.saveImageCompressed(imgName23, imgInput23.readAllBytes());
		this.imageService.saveImageCompressed(imgName24, imgInput24.readAllBytes());
		this.imageService.saveImageCompressed(imgName25, imgInput25.readAllBytes());
		this.imageService.saveImageCompressed(imgName26, imgInput26.readAllBytes());
		this.imageService.saveImageCompressed(imgName27, imgInput27.readAllBytes());
		this.imageService.saveImageCompressed(imgName28, imgInput28.readAllBytes());
		this.imageService.saveImageCompressed(imgName29, imgInput29.readAllBytes());
		this.imageService.saveImageCompressed(imgName30, imgInput30.readAllBytes());
		this.imageService.saveImageCompressed(imgName31, imgInput31.readAllBytes());
		this.imageService.saveImageCompressed(imgName32, imgInput32.readAllBytes());
		this.imageService.saveImageCompressed(imgName33, imgInput33.readAllBytes());
		this.imageService.saveImageCompressed(imgName34, imgInput34.readAllBytes());
		this.imageService.saveImageCompressed(imgName35, imgInput35.readAllBytes());
		this.imageService.saveImageCompressed(imgName36, imgInput36.readAllBytes());
		this.imageService.saveImageCompressed(imgName37, imgInput37.readAllBytes());
		this.imageService.saveImageCompressed(imgName38, imgInput38.readAllBytes());
		this.imageService.saveImageCompressed(imgName39, imgInput39.readAllBytes());
		this.imageService.saveImageCompressed(imgName40, imgInput40.readAllBytes());
		this.imageService.saveImageCompressed(imgName41, imgInput41.readAllBytes());
		this.imageService.saveImageCompressed(imgName42, imgInput42.readAllBytes());
		this.imageService.saveImageCompressed(imgName43, imgInput43.readAllBytes());
		this.imageService.saveImageCompressed(imgName44, imgInput44.readAllBytes());
		this.imageService.saveImageCompressed(imgName45, imgInput45.readAllBytes());
		this.imageService.saveImageCompressed(imgName46, imgInput46.readAllBytes());
		this.imageService.saveImageCompressed(imgName47, imgInput47.readAllBytes());
		this.imageService.saveImageCompressed(imgName48, imgInput48.readAllBytes());
		this.imageService.saveImageCompressed(imgName49, imgInput49.readAllBytes());
		this.imageService.saveImageCompressed(imgName50, imgInput50.readAllBytes());
		this.imageService.saveImageCompressed(imgName51, imgInput51.readAllBytes());
		this.imageService.saveImageCompressed(imgName52, imgInput52.readAllBytes());
		this.imageService.saveImageCompressed(imgName53, imgInput53.readAllBytes());
		this.imageService.saveImageCompressed(imgName54, imgInput54.readAllBytes());
		this.imageService.saveImageCompressed(imgName55, imgInput55.readAllBytes());
		this.imageService.saveImageCompressed(imgName56, imgInput56.readAllBytes());
		this.imageService.saveImageCompressed(imgName57, imgInput57.readAllBytes());
		this.imageService.saveImageCompressed(imgName58, imgInput58.readAllBytes());
		this.imageService.saveImageCompressed(imgName59, imgInput59.readAllBytes());
		this.imageService.saveImageCompressed(imgName84, imgInput84.readAllBytes());


		imgInput8.close();
		imgInput9.close();
		imgInput10.close();
		imgInput11.close();
		imgInput12.close();
		imgInput13.close();
		imgInput14.close();
		imgInput15.close();
		imgInput16.close();
		imgInput17.close();
		imgInput18.close();
		imgInput19.close();
		imgInput20.close();
		imgInput21.close();
		imgInput22.close();
		imgInput23.close();
		imgInput24.close();
		imgInput25.close();
		imgInput26.close();
		imgInput27.close();
		imgInput28.close();
		imgInput29.close();
		imgInput30.close();
		imgInput31.close();
		imgInput32.close();
		imgInput33.close();
		imgInput34.close();
		imgInput35.close();
		imgInput36.close();
		imgInput37.close();
		imgInput38.close();
		imgInput39.close();
		imgInput40.close();
		imgInput41.close();
		imgInput42.close();
		imgInput43.close();
		imgInput44.close();
		imgInput45.close();
		imgInput46.close();
		imgInput47.close();
		imgInput48.close();
		imgInput49.close();
		imgInput50.close();
		imgInput51.close();
		imgInput52.close();
		imgInput53.close();
		imgInput54.close();
		imgInput55.close();
		imgInput56.close();
		imgInput57.close();
		imgInput58.close();
		imgInput59.close();
		imgInput84.close();

	}

}
