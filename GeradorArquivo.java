import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeradorArquivo {
    public void salvarJson(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        String arquivoDestino = "CEPsGerados" + File.separator + "CEP(" + endereco.cep() + ").json";
        FileWriter escrita = new FileWriter(arquivoDestino);
        escrita.write(gson.toJson(endereco));
        escrita.close();
    }
}
