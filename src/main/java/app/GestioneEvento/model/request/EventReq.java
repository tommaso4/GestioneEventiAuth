package app.GestioneEvento.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EventReq {
    @NotBlank(message = "title required")
    private String title;
    @NotBlank(message = "description required")
    private String description;
    @NotBlank(message = "date required")
    private LocalDate date;
    @NotBlank(message = "location required")
    private String location;
    @NotBlank(message = "nrPlace required")
    private int nrPlace;
}
