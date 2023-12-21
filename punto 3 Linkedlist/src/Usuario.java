 public class Usuario {
    String nombre;
    int cedula;
    int id;
    

    public Usuario(String nombre,int cedula,int id){
        this.nombre = nombre;
        this.cedula = cedula;
        this.id = id;
        

    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCedula() {
        return cedula;
    }
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
