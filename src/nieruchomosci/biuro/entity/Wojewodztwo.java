
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
@Table(name = "Wojewodztwo")
@NamedQueries({
    @NamedQuery(name = "Wojewodztwo.findAll", query = "SELECT w FROM Wojewodztwo w"),
    @NamedQuery(name = "Wojewodztwo.findById", query = "SELECT w FROM Wojewodztwo w WHERE w.id = :id")})
public class Wojewodztwo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "Wojewodztwo")
    private String wojewodztwo;

    public Wojewodztwo() {
    }

    public Wojewodztwo(Integer id) {
        this.id = id;
    }

    public Wojewodztwo(Integer id, String wojewodztwo) {
        this.id = id;
        this.wojewodztwo = wojewodztwo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWojewodztwo() {
        return wojewodztwo;
    }

    public void setWojewodztwo(String wojewodztwo) {
        this.wojewodztwo = wojewodztwo;
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
        if (!(object instanceof Wojewodztwo)) {
            return false;
        }
        Wojewodztwo other = (Wojewodztwo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplikacja034565.Wojewodztwo[ id=" + id + " ]";
    }

}
