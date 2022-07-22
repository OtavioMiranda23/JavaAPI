import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    public void cria (InputStream inputStream, String nomeArquivo ) throws Exception{
        
                //leitura da imagem
                //FileInputStream inputStream = new FileInputStream("entrada/filmeMaior.jpg");
                //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
                BufferedImage imagemOriginal = ImageIO.read(inputStream);
        
                //cria nova imagem com transparencia e tamanho novo
                 int largura = imagemOriginal.getWidth();
                 int altura = imagemOriginal.getHeight();
                 int novaAltura = altura + 200;
                 BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
                 
                 //copiar a imagem original para nova imagem (memoria)
                 Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
                 graphics.drawImage(imagemOriginal, 0, 0, null);

                 //configurar fonte
                 Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
                 graphics.setFont(fonte);
                 graphics.setColor(Color.YELLOW);
                 
                //escrever uma frase na nova imagem
                graphics.drawString("Topzera", 100, novaAltura - 100);

                //escrever a nova imagem em um arquivo
                ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }
}
