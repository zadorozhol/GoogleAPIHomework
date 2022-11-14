package org.prog.dto;

import lombok.*;

import javax.lang.model.element.Name;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RandomUserResults {

    @Getter
    @Setter
    private List <PersonDto> results;
}
