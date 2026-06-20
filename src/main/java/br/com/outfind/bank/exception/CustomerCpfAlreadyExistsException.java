package br.com.outfind.bank.exception;

public class CustomerCpfAlreadyExistsException extends RuntimeException {

    public CustomerCpfAlreadyExistsException() {
        super("Customer with this CPF already exists");
    }

}