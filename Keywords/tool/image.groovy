package tool
import java.awt.Graphics2D
import java.awt.image.*
import java.awt.*
import javax.imageio.ImageIO

import com.kms.katalon.core.annotation.Keyword

public class image {
	@Keyword
	def resize(String inputImagePath, int scaledWidth, int scaledHeight) throws IOException {
		File inputFile = new File(inputImagePath)

		BufferedImage inputImage = ImageIO.read(inputFile)

		BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, inputImage.getType())

		Graphics2D g2d = outputImage.createGraphics()

		g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null)

		g2d.dispose()

		String outputImagePath = System.getProperty('user.dir') + '\\capturedImage.png'

		String formatName = outputImagePath.substring(outputImagePath.lastIndexOf('.') + 1)

		ImageIO.write(outputImage, formatName, new File(outputImagePath))

		return outputImagePath
	}
	@Keyword
	def resizeWithPercent(String inputImagePath, double percent) throws IOException {
		File inputFile = new File(inputImagePath)

		BufferedImage inputImage = ImageIO.read(inputFile)

		int scaledWidth = ((inputImage.getWidth() * percent) as int)

		int scaledHeight = ((inputImage.getHeight() * percent) as int)

		BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, inputImage.getType())

		Graphics2D g2d = outputImage.createGraphics()

		g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null)

		g2d.dispose()

		String outputImagePath = System.getProperty('user.dir') + '\\capturedImage.png'

		String formatName = outputImagePath.substring(outputImagePath.lastIndexOf('.') + 1)

		ImageIO.write(outputImage, formatName, new File(outputImagePath))

		return outputImagePath
	}

	@Keyword
	def grayToBlackAndWhite(BufferedImage img, int precision) {
		int w = img.getWidth()

		int h = img.getHeight()

		precision = (0 <= precision) && (precision <= 100) ? precision : 50

		int limit = (255 * precision) / 100

		for (int i = 0; i < w; ++i) {
			for (int j = 0; j < h; ++j) {
				Color color = new Color(img.getRGB(i, j))

				if (((limit <= color.getRed()) || (limit <= color.getGreen())) || (limit <= color.getBlue())) {
					img.setRGB(i, j, Color.WHITE.getRGB())
				} else {
					img.setRGB(i, j, Color.BLACK.getRGB())
				}
			}
		}
		ImageIO.write(img, 'png', new File('capturedImage.png'))
		def output = System.getProperty('user.dir') + '\\capturedImage.png'

		return output
	}
}
