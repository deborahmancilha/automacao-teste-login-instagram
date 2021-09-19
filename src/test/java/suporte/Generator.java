package suporte;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {
    public static String dataHoraParaArquivo() {
        //Retorna uma string de data
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
    }

}
