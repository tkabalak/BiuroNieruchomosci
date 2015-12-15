
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
@Table(name = "Szczegoly")
@NamedQueries({
    @NamedQuery(name = "Szczegoly.findAll", query = "SELECT s FROM Szczegoly s"),
    @NamedQuery(name = "Szczegoly.findById", query = "SELECT s FROM Szczegoly s WHERE s.id = :id"),
    @NamedQuery(name = "Szczegoly.findByIDoferty", query = "SELECT s FROM Szczegoly s WHERE s.iDoferty = :iDoferty"),
    @NamedQuery(name = "Szczegoly.findByCieplawoda", query = "SELECT s FROM Szczegoly s WHERE s.cieplawoda = :cieplawoda"),
    @NamedQuery(name = "Szczegoly.findByKuchnia", query = "SELECT s FROM Szczegoly s WHERE s.kuchnia = :kuchnia"),
    @NamedQuery(name = "Szczegoly.findByGaraz", query = "SELECT s FROM Szczegoly s WHERE s.garaz = :garaz"),
    @NamedQuery(name = "Szczegoly.findByMiejsceparkingowe", query = "SELECT s FROM Szczegoly s WHERE s.miejsceparkingowe = :miejsceparkingowe"),
    @NamedQuery(name = "Szczegoly.findByPiwnica", query = "SELECT s FROM Szczegoly s WHERE s.piwnica = :piwnica"),
    @NamedQuery(name = "Szczegoly.findByBalkon", query = "SELECT s FROM Szczegoly s WHERE s.balkon = :balkon"),
    @NamedQuery(name = "Szczegoly.findByWinda", query = "SELECT s FROM Szczegoly s WHERE s.winda = :winda"),
    @NamedQuery(name = "Szczegoly.findByZsyp", query = "SELECT s FROM Szczegoly s WHERE s.zsyp = :zsyp"),
    @NamedQuery(name = "Szczegoly.findByUmeblowanie", query = "SELECT s FROM Szczegoly s WHERE s.umeblowanie = :umeblowanie")})
public class Szczegoly implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ID_oferty")
    private int iDoferty;
    @Basic(optional = false)
    @Lob
    @Column(name = "Rodzaj_wlasnosci")
    private String rodzajwlasnosci;
    @Basic(optional = false)
    @Lob
    @Column(name = "Okna")
    private String okna;
    @Basic(optional = false)
    @Lob
    @Column(name = "Ogrzewanie")
    private String ogrzewanie;
    @Basic(optional = false)
    @Column(name = "Ciepla_woda")
    private short cieplawoda;
    @Basic(optional = false)
    @Lob
    @Column(name = "Lazienka")
    private String lazienka;
    @Basic(optional = false)
    @Lob
    @Column(name = "WC")
    private String wc;
    @Basic(optional = false)
    @Column(name = "Kuchnia")
    private short kuchnia;
    @Basic(optional = false)
    @Column(name = "Garaz")
    private short garaz;
    @Basic(optional = false)
    @Column(name = "Miejsce_parkingowe")
    private short miejsceparkingowe;
    @Basic(optional = false)
    @Column(name = "Piwnica")
    private short piwnica;
    @Basic(optional = false)
    @Column(name = "Balkon")
    private short balkon;
    @Basic(optional = false)
    @Column(name = "Winda")
    private short winda;
    @Basic(optional = false)
    @Column(name = "Zsyp")
    private short zsyp;
    @Basic(optional = false)
    @Column(name = "Umeblowanie")
    private short umeblowanie;

    public Szczegoly() {
    }

    public Szczegoly(Integer id) {
        this.id = id;
    }

    public Szczegoly(Integer id, int iDoferty, String rodzajwlasnosci, String okna, String ogrzewanie, short cieplawoda, String lazienka, String wc, short kuchnia, short garaz, short miejsceparkingowe, short piwnica, short balkon, short winda, short zsyp, short umeblowanie) {
        this.id = id;
        this.iDoferty = iDoferty;
        this.rodzajwlasnosci = rodzajwlasnosci;
        this.okna = okna;
        this.ogrzewanie = ogrzewanie;
        this.cieplawoda = cieplawoda;
        this.lazienka = lazienka;
        this.wc = wc;
        this.kuchnia = kuchnia;
        this.garaz = garaz;
        this.miejsceparkingowe = miejsceparkingowe;
        this.piwnica = piwnica;
        this.balkon = balkon;
        this.winda = winda;
        this.zsyp = zsyp;
        this.umeblowanie = umeblowanie;
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

    public String getRodzajwlasnosci() {
        return rodzajwlasnosci;
    }

    public void setRodzajwlasnosci(String rodzajwlasnosci) {
        this.rodzajwlasnosci = rodzajwlasnosci;
    }

    public String getOkna() {
        return okna;
    }

    public void setOkna(String okna) {
        this.okna = okna;
    }

    public String getOgrzewanie() {
        return ogrzewanie;
    }

    public void setOgrzewanie(String ogrzewanie) {
        this.ogrzewanie = ogrzewanie;
    }

    public short getCieplawoda() {
        return cieplawoda;
    }

    public void setCieplawoda(short cieplawoda) {
        this.cieplawoda = cieplawoda;
    }

    public String getLazienka() {
        return lazienka;
    }

    public void setLazienka(String lazienka) {
        this.lazienka = lazienka;
    }

    public String getWc() {
        return wc;
    }

    public void setWc(String wc) {
        this.wc = wc;
    }

    public short getKuchnia() {
        return kuchnia;
    }

    public void setKuchnia(short kuchnia) {
        this.kuchnia = kuchnia;
    }

    public short getGaraz() {
        return garaz;
    }

    public void setGaraz(short garaz) {
        this.garaz = garaz;
    }

    public short getMiejsceparkingowe() {
        return miejsceparkingowe;
    }

    public void setMiejsceparkingowe(short miejsceparkingowe) {
        this.miejsceparkingowe = miejsceparkingowe;
    }

    public short getPiwnica() {
        return piwnica;
    }

    public void setPiwnica(short piwnica) {
        this.piwnica = piwnica;
    }

    public short getBalkon() {
        return balkon;
    }

    public void setBalkon(short balkon) {
        this.balkon = balkon;
    }

    public short getWinda() {
        return winda;
    }

    public void setWinda(short winda) {
        this.winda = winda;
    }

    public short getZsyp() {
        return zsyp;
    }

    public void setZsyp(short zsyp) {
        this.zsyp = zsyp;
    }

    public short getUmeblowanie() {
        return umeblowanie;
    }

    public void setUmeblowanie(short umeblowanie) {
        this.umeblowanie = umeblowanie;
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
        if (!(object instanceof Szczegoly)) {
            return false;
        }
        Szczegoly other = (Szczegoly) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplikacja034565.Szczegoly[ id=" + id + " ]";
    }

}
