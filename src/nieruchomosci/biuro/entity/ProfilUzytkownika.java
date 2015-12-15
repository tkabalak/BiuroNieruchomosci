
package nieruchomosci.biuro.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "ProfilUzytkownika")
@NamedQueries({
    @NamedQuery(name = "ProfilUzytkownika.findAll", query = "SELECT p FROM ProfilUzytkownika p"),
    @NamedQuery(name = "ProfilUzytkownika.findById", query = "SELECT p FROM ProfilUzytkownika p WHERE p.id = :id"),
    @NamedQuery(name = "ProfilUzytkownika.findByIDuzytkownika", query = "SELECT p FROM ProfilUzytkownika p WHERE p.iDuzytkownika = :iDuzytkownika")})
public class ProfilUzytkownika implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ID_uzytkownika")
    private int iDuzytkownika;
    @Basic(optional = false)
    @Lob
    @Column(name = "Imie")
    private String imie;
    @Basic(optional = false)
    @Lob
    @Column(name = "Nazwisko")
    private String nazwisko;

    public ProfilUzytkownika() {
    }

    public ProfilUzytkownika(Integer id) {
        this.id = id;
    }

    public ProfilUzytkownika(Integer id, int iDuzytkownika, String imie, String nazwisko) {
        this.id = id;
        this.iDuzytkownika = iDuzytkownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIDuzytkownika() {
        return iDuzytkownika;
    }

    public void setIDuzytkownika(int iDuzytkownika) {
        this.iDuzytkownika = iDuzytkownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfilUzytkownika)) {
            return false;
        }
        ProfilUzytkownika other = (ProfilUzytkownika) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProfilUzytkownika{" + "id=" + id + ", iDuzytkownika=" + iDuzytkownika + ", imie=" + imie + ", nazwisko=" + nazwisko + '}';
    }

    

}
