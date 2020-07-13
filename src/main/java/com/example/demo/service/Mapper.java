package com.example.demo.service;

public interface Mapper<Source, Target> {
	
	Target mapToDTO(Source source);
}
