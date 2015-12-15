
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
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Adres")
@NamedQueries({
    @NamedQuery(name = "Adres.findAll", query = "SELECT a FROM Adres a"),
    @NamedQuery(name = "Adres.findById", query = "SELECT a FROM Adres a WHERE a.id = :id"),
    @NamedQuery(name = "Adres.findByIDoferty", query = "SELECT a FROM Adres a WHERE a.iDoferty = :iDoferty"),
    @NamedQuery(name = "Adres.findByIDwojewodztwa", query = "SELECT a FROM Adres a WHERE a.iDwojewodztwa = :iDwojewodztwa")})
public class Adres implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ID_oferty")
//    @OneToOne(mappedBy = "Oferta", )
    private int iDoferty;
    @Basic(optional = false)
    @Lob
    @Column(name = "Panstwo")
    private String panstwo;
    @Basic(optional = false)
    @Column(name = "ID_wojewodztwa")
    private int iDwojewodztwa;
    @Basic(optional = false)
    @Lob
    @Column(name = "Dzielnica_wies")
    private String dzielnicawies;
    @Basic(optional = false)
    @Lob
    @Column(name = "Ulica")
    private String ulica;

    public Adres() {
    }

    public Adres(Integer id) {
        this.id = id;
    }

    public Adres(Integer id, int iDoferty, String panstwo, int iDwojewodztwa, String dzielnicawies, String ulica) {
        this.id = id;
        this.iDoferty = iDoferty;
        this.panstwo = panstwo;
        this.iDwojewodztwa = iDwojewodztwa;
        this.dzielnicawies = dzielnicawies;
        this.ulica = ulica;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIDoferty() {
        return iDoferty;
    }

    public void setIDoferty(int iDoferty) {
        this.iDoferty = iDoferty;
    }

    public String getPanstwo() {
        return panstwo;
    }

    public void setPanstwo(String panstwo) {
        this.panstwo = panstwo;
    }

    public int getIDwojewodztwa() {
        return iDwojewodztwa;
    }

    public void setIDwojewodztwa(int iDwojewodztwa) {
        this.iDwojewodztwa = iDwojewodztwa;
    }

    public String getDzielnicawies() {
        return dzielnicawies;
    }

    public void setDzielnicawies(String dzielnicawies) {
        this.dzielnicawies = dzielnicawies;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
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
        if (!(object instanceof Adres)) {
            return false;
        }
        Adres other = (Adres) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Adres{" + "id=" + id + ", iDoferty=" + iDoferty + ", panstwo=" + panstwo + ", iDwojewodztwa=" + iDwojewodztwa + ", dzielnicawies=" + dzielnicawies + ", ulica=" + ulica + '}';
    }

    

}
