package com.example.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.course.services.exceptions.DatabaseException;
import com.example.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

/*
Esse código tem o propósito de interceptar exceções do tipo ResourceNotFoundException que ocorrem em 
qualquer parte da aplicação. Quando essa exceção é lançada, o método resourceNotFound é chamado para 
retornar uma resposta personalizada ao cliente. Ele monta um objeto StandardError contendo informações 
sobre o erro (timestamp, código de status, mensagem de erro, a causa do erro, e a URI da requisição), 
e envia uma resposta HTTP com o status 404 Not Found e o corpo detalhando o erro.

O objetivo principal é fornecer um tratamento uniforme para erros de recurso não encontrado e enviar 
respostas claras para o cliente.
*/

@ControllerAdvice
public class ResourceExceptionHandler { // Classe que intercepta exceções em toda a aplicação

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) { // Trata exceções do tipo ResourceNotFoundException
        String error = "Resource not found"; // Define a mensagem de erro
        HttpStatus status = HttpStatus.NOT_FOUND; // Define o status HTTP 404 (Not Found)
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI()); // Cria um objeto StandardError com detalhes do erro
        return ResponseEntity.status(status).body(err); // Retorna a resposta HTTP com o status e o corpo contendo os detalhes do erro
    }
    
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) { // Trata exceções do tipo DatabaseException
        String error = "Database error"; // Define a mensagem de erro
        HttpStatus status = HttpStatus.BAD_REQUEST; // Define o status de BAD_REQUEST
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI()); // Cria um objeto StandardError com detalhes do erro
        return ResponseEntity.status(status).body(err); // Retorna a resposta HTTP com o status e o corpo contendo os detalhes do erro
    }
}
