package com.example.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L; // Identificador único para a serialização da classe
    
    public ResourceNotFoundException(Object id) { // Construtor que recebe o ID do recurso não encontrado
        super("Resource not found. Id " + id); // Chama o construtor da superclasse com a mensagem de erro personalizada
    }
}