package vn.edu.uit.Demo.GraphQL2.model.dto.book_dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class dtoReqBook {
    private String title;
    private Long authorId;

}
