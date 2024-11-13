package pack.controller;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
	private String id, name;
	private int price;
	private LocalDate regdate;
}
