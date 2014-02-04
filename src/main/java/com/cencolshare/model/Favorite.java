package com.cencolshare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_favorite")
public class Favorite {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="favorite_id")
	private int favoriteId;
}
