import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageCropper {

    public static void main(String[] args) {
        try {
            // Load the original image
            BufferedImage originalImage = ImageIO.read(new File("Capture_d_écran_2024-12-05_222227-removebg-preview.png"));

            // Original image dimensions
            int originalWidth = originalImage.getWidth();
            int originalHeight = originalImage.getHeight();

            // Desired crop dimensions (250x250)
            int cropWidth = 250;
            int cropHeight = 250;

            // Calculate the center of the original image
            int centerX = originalWidth / 2;
            int centerY = originalHeight / 2;

            // Calculate the top-left corner of the crop area (ensure it stays within bounds)
            int x = centerX - cropWidth / 2;
            int y = centerY - cropHeight / 2;

            // Ensure the crop area doesn't go outside the original image bounds
            x = Math.max(0, Math.min(x, originalWidth - cropWidth));
            y = Math.max(0, Math.min(y, originalHeight - cropHeight));

            // Crop the image
            BufferedImage croppedImage = originalImage.getSubimage(x, y, cropWidth, cropHeight);

            // Save the cropped image to a new file
            ImageIO.write(croppedImage, "PNG", new File("cropped_image_left.png"));
            
            System.out.println("Image successfully cropped!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
