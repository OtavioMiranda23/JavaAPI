import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtatorDeConteudoDaNasa {
    public List<Conteudo> extraiConteudos(String json) {
            //extrair os dados (título, poster, classificação)
            JsonParser parser = new JsonParser();
            List<Map<String, String>> listaDeAtributos = parser.parse(json);

            List<Conteudo> conteudos = new ArrayList<>();

            //popular lista de conteudos
            for ( Map<String, String> atributos : listaDeAtributos) {
                String titulo = atributos.get("title");
                String urlImagem = atributos.get("url");
                Conteudo conteudo = new Conteudo(titulo, urlImagem);

                conteudos.add(conteudo);
            }

            return conteudos;
    }
}
