package projectR.backend.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projectR.backend.model.Image;
import projectR.backend.repository.ImageRepo;

@Service
public class ImageService {
	
	@Autowired
	private ImageRepo imageRepo;
	
	/**
	 * Finds if an image with the given name exists and returns the decompressed byte array representing 
	 * the requested image. 
	 * @param imageName the name of the requested image
	 * @return byte array representing the requested image if such image exists in the repo, <code>null</code> otherwise.
	 * @throws IOException 
	 * @throws DataFormatException 
	 */
	public byte[] retrieveAndDecompress(String imageName) throws DataFormatException, IOException {
		Optional<Image> img = imageRepo.findByName(imageName);
		return img.isPresent() ? decompressBytes(img.get().getPicByte()) : null;
	}
	
	/**
	 * Finds all images containing the given character sequence. 
	 * @param partOfName
	 * @return list of images containing the given character sequence.
	 */
	public List<Image> retrieveByNameContaining(String partOfName) {
		return imageRepo.findByNameContaining(partOfName);
	}
	
	/**
	 * Finds all images stored in the repository.
	 * @return list of all images from the repository.
	 */
	public List<Image> retrieveAll() {
		return imageRepo.findAll();
	}
	
	public boolean deleteImage(String imageName) {
		Optional<Image> image = imageRepo.findByName(imageName);
		
		if(!image.isPresent()) {
			return false;
		}
		
		imageRepo.delete(image.get());
		return true;
	}
	
	
	
	/**
	 * Saves the given image file in the repository.
	 * @param imageName the name of the image
	 * @param picByte the given image file
	 * @return the saved image if the saving was successful, <code>null</code> if an image with such name already exists in the repo.
	 * @throws IOException if an error occurs during reading the file
	 */
	public Image saveImageCompressed(String imageName, byte[] picByte) throws IOException {
		if(imageRepo.findByName(imageName).isPresent()) {
			return null;
		}
		Image img = new Image(imageName, compressBytes(picByte));
		imageRepo.save(img);
		
		return img;
	}
	
	
	/**
	 * Compresses the given data array.
	 * @param data given array of data
	 * @return compressed byte array from the given data.
	 * @throws IOException 
	 */
	public static byte[] compressBytes(byte[] data) throws IOException {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		
		outputStream.close();
		
		//System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();
	}
	
	/**
	 * Decompresses the given data array.
	 * @param data given byte array
	 * @return decompressed byte array from the given data.
	 * @throws DataFormatException 
	 * @throws IOException 
	 */
	public static byte[] decompressBytes(byte[] data) throws DataFormatException, IOException {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		
		while (!inflater.finished()) {
			int count = inflater.inflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		outputStream.close();
		
		return outputStream.toByteArray();
	}
	
}
