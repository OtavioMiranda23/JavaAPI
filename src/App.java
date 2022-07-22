import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        // fazer uma conexão HTTP e buscar os 250 top filmes;
        String url =  "https://alura-imdb-api.herokuapp.com/movies";

        ClientHttp http = new ClientHttp();
        String json = http.buscaDados(url);


        

        
        
        //exibir e manipular os dados
        GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();
        for (int i = 0; i < 3; i++) {

            Map<String, String> conteudo = listaDeConteudos.get(i);

            String urlImagem = conteudo.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            String titulo = conteudo.get("title");
            
            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = "saida/" + titulo + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(titulo);
        };
    }
}
