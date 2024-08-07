package com.patricklima.myapp.notifications.entities;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 1024, nullable = false)
	private String body;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false, referencedColumnName = "id")
	private Category category;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;

	@OneToMany(mappedBy = "message", fetch = FetchType.LAZY)
	private Set<MessageDispatch> messageDispatches;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Set<MessageDispatch> getMessageDispatches() {
		return messageDispatches;
	}

	public void setMessageDispatches(Set<MessageDispatch> messageDispatches) {
		this.messageDispatches = messageDispatches;
	}
}
