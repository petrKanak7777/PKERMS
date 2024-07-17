package cz.erms.backend.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FileRequest {

    @NotBlank
    @Size(min = 36, max = 36)
    @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}+$")
    private String userId;

    @NotBlank
    @Size(min = 3, max = 256)
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$")
    private String name;
}
