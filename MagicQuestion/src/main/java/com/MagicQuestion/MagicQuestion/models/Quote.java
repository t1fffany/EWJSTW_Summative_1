package com.MagicQuestion.MagicQuestion.models;

@Entity
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String quote;

    // Constructors, getters, and setters


}