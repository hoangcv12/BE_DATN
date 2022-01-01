package com.poly.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "Orders")
public class Order implements Serializable{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="Id")
		private Integer id;
		
		@Column(name="Address")
		private String address;
		@Temporal(TemporalType.DATE)
	
		@ManyToOne
		@JoinColumn(name = "Username")
		private Account account;
		
		@Column(name="Sdt")
		private String sdt;

		@Column(name="fullname")
		private String fullname;

		@Column(name = "order_status") // 0:Đang chờ xác nhận , 1:Đã hủy , 2:Đang giao , 3:Giao hàng thành công
		private Integer orderStatus;

		@Column(name = "note")
		private String note;

		@Column(name = "total")
		private Float total;

		@Column(name = "created_date")
		private LocalDateTime createdDate;

		@Column(name = "updated_date")
		private LocalDateTime updatedDate;

		@JsonIgnore
		@OneToMany(mappedBy = "order")
		private List<OrderDetail> orderDetails;
}
