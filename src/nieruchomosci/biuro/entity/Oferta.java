
package nieruchomosci.biuro.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Oferta")
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o"),
    @NamedQuery(name = "Oferta.findById", query = "SELECT o FROM Oferta o WHERE o.id = :id"),
    @NamedQuery(name = "Oferta.findByIDprofil", query = "SELECT o FROM Oferta o WHERE o.iDprofil = :iDprofil"),
    @NamedQuery(name = "Oferta.findByCzynsz", query = "SELECT o FROM Oferta o WHERE o.czynsz = :czynsz"),
    @NamedQuery(name = "Oferta.findByPowM2", query = "SELECT o FROM Oferta o WHERE o.powM2 = :powM2"),
    @NamedQuery(name = "Oferta.findByPietro", query = "SELECT o FROM Oferta o WHERE o.pietro = :pietro"),
    @NamedQuery(name = "Oferta.findByIloscpieter", query = "SELECT o FROM Oferta o WHERE o.iloscpieter = :iloscpieter"),
    @NamedQuery(name = "Oferta.findByRokbudowy", query = "SELECT o FROM Oferta o WHERE o.rokbudowy = :rokbudowy"),
    @NamedQuery(name = "Oferta.findByWidoczny", query = "SELECT o FROM Oferta o WHERE o.widoczny = :widoczny"),
    @NamedQuery(name = "Oferta.findByDatautworzenia", query = "SELECT o FROM Oferta o WHERE o.datautworzenia = :datautworzenia")})
public class Oferta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ID_profil")
    private int iDprofil;
    @Basic(optional = false)
    @Lob
    @Column(name = "Transakcja")
    private String transakcja;
    @Basic(optional = false)
    @Column(name = "Czynsz")
    private long czynsz;
    @Basic(optional = false)
    @Column(name = "PowM2")
    private float powM2;
    @Basic(optional = false)
    @Column(name = "Pietro")
    private int pietro;
    @Basic(optional = false)
    @Column(name = "Ilosc_pieter")
    private int iloscpieter;
    @Basic(optional = false)
    @Column(name = "Rok_budowy")
    private int rokbudowy;
    @Basic(optional = false)
    @Column(name = "Widoczny")
    private short widoczny;
    @Basic(optional = false)
    @Column(name = "Data_utworzenia")
    @Temporal(TemporalType.DATE)
    private Date datautworzenia;

    public Oferta() {
    }

    public Oferta(Integer id) {
        this.id = id;
    }

    public Oferta(Integer id, int iDprofil, String transakcja, long czynsz, float powM2, int pietro, int iloscpieter, int rokbudowy, short widoczny, Date datautworzenia) {
        this.id = id;
        this.iDprofil = iDprofil;
        this.transakcja = transakcja;
        this.czynsz = czynsz;
        this.powM2 = powM2;
        this.pietro = pietro;
        this.iloscpieter = iloscpieter;
        this.rokbudowy = rokbudowy;
        this.widoczny = widoczny;
        this.datautworzenia = datautworzenia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIDprofil() {
        return iDprofil;
    }

    public void setIDprofil(int iDprofil) {
        this.iDprofil = iDprofil;
    }

    public String getTransakcja() {
        return transakcja;
    }

    public void setTransakcja(String transakcja) {
        this.transakcja = transakcja;
    }

    public long getCzynsz() {
        return czynsz;
    }

    public void setCzynsz(long czynsz) {
        this.czynsz = czynsz;
    }

    public float getPowM2() {
        return powM2;
    }

    public void setPowM2(float powM2) {
        this.powM2 = powM2;
    }

    public int getPietro() {
        return pietro;
    }

    public void setPietro(int pietro) {
        this.pietro = pietro;
    }

    public int getIloscpieter() {
        return iloscpieter;
    }

    public void setIloscpieter(int iloscpieter) {
        this.iloscpieter = iloscpieter;
    }

    public int getRokbudowy() {
        return rokbudowy;
    }

    public void setRokbudowy(int rokbudowy) {
        this.rokbudowy = rokbudowy;
    }

    public short getWidoczny() {
        return widoczny;
    }

    public void setWidoczny(short widoczny) {
        this.widoczny = widoczny;
    }

    public Date getDatautworzenia() {
        return datautworzenia;
    }

    public void setDatautworzenia(Date datautworzenia) {
        this.datautworzenia = datautworzenia;
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
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Oferta{" + "id=" + id + '}';
    }

    

}
