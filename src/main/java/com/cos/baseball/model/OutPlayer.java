package com.cos.baseball.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude = "player")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OutPlayer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "reason")
	private String reason;
	
	@Column(name = "outDay")
	private String outDay;
	

	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "playerId")
	private Player player;
	
}