package ru.molokoin.j210_rest_service;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "address")
@Table(name = "Addresses", schema = "j200", catalog = "")
public class ModelAddress implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ip", length = 15)
    private String ip;
    @Column(name = "mac", length = 17)
    private String mac;
    @Column(name = "model", length = 100)
    private String model;
    @Column(name = "address", length = 100)
    private String address;
    // @Column(name = "client_id")
    // private Integer client_id;
    @Basic(optional = false)
    @JoinColumn(name = "client_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ModelClient client;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getMac() {
        return mac;
    }
    public void setMac(String mac) {
        this.mac = mac;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    // public Integer getClient_id() {
    //     return client_id;
    // }
    // public void setClient_id(Integer client_id) {
    //     this.client_id = client_id;
    // }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((ip == null) ? 0 : ip.hashCode());
        result = prime * result + ((mac == null) ? 0 : mac.hashCode());
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        //result = prime * result + ((client_id == null) ? 0 : client_id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ModelAddress other = (ModelAddress) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (ip == null) {
            if (other.ip != null)
                return false;
        } else if (!ip.equals(other.ip))
            return false;
        if (mac == null) {
            if (other.mac != null)
                return false;
        } else if (!mac.equals(other.mac))
            return false;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        // if (client_id == null) {
        //     if (other.client_id != null)
        //         return false;
        // } else if (!client_id.equals(other.client_id))
        //     return false;
        return true;
    }
    @Override
    public String toString() {
        return "ModelAddress [id=" + id + ", ip=" + ip + ", mac=" + mac + ", model=" + model + ", address=" + address
                //+ ", client_id=" + client_id 
                + "]";
    }

    @Transient
    public ModelClient getClient() {
        return client;
    }

    public void setClient(ModelClient client) {
        this.client = client;
    }

    


}
