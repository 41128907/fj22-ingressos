package br.com.caelum.ingresso.model.form;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class SessaoForm {
	@NotNull
	private Integer salaId;
	@NotNull
	@DateTimeFormat(pattern="HH:mm")
	private LocalTime horario;
	@NotNull
	private Integer filmeId;
	
	public Sessao toSessao(SalaDao salaDao, FilmeDao filmeDao) {
		Filme filme = filmeDao.findOne(filmeId);
		Sala sala = salaDao.findOne(salaId);
		
		Sessao sessao = new Sessao(this.horario, sala, filme);
		
		return sessao;
	}

	public Integer getSalaId() {
		return salaId;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public Integer getFilmeId() {
		return filmeId;
	}

	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public void setFilmeId(Integer filmeId) {
		this.filmeId = filmeId;
	}
	
	
}
