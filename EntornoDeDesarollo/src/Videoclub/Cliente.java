package Videoclub;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String NIF;

    private String nombre;

    private String dirrecion;

    private String telefono;

    private String email;

    private String numSocio;

    private String fecAlta;

    private String sancion;

    public List<Alquiler> alquiler = new ArrayList<Alquiler> ();

    public float getSacion() {
        // TODO Auto-generated return
        return 0f;
    }

    public void setSancion(final float importe) {
    }

    public boolean CompararNIF(final String NIF) {
        // TODO Auto-generated return
        return false;
    }

}
