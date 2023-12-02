package com.jornada.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "destino")
public class Destino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String cidade;
	
	@Column(nullable = false)
	private String pais;
	
	@Column(nullable = false)
	private double preco;

	@Column(nullable = false)
	private boolean promocao;
	
	public Destino() {
	}

	public Destino(String cidade, String pais, double preco, boolean promocao) {
		this.cidade = cidade;
		this.pais = pais;
		this.preco = preco;
		this.promocao = promocao;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isPromocao() {
		return promocao;
	}

	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}
	
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
        result = prime * result + ((pais == null) ? 0 : pais.hashCode());
        result = prime * result + (promocao ? 1231 : 1237);
        long temp;
        temp = Double.doubleToLongBits(preco);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Destino other = (Destino) obj;

        return id != null && id.equals(other.id);
    }

    @Override
    public String toString() {
        return "Destino [id=" + id + ", cidade=" + cidade + ", pais=" + pais + ", preco=" + preco
                + ", promocao=" + promocao + "]";
    }
}
	
	


