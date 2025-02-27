package com.adi.dum.dto;

import com.adi.dum.model.Address;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
public class TrainingCenterDTO {

    @NotBlank(message = "Center Name is required")
    @Size(max = 40, message = "Center Name must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "Center Code is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center Code must be exactly 12 alphanumeric characters")
    private String centerCode;

    @NotNull(message = "Address is required")
    private Address address;

    @Positive(message = "Student Capacity must be a positive number")
    private Integer studentCapacity;

    @NotNull(message = "Courses Offered cannot be null")
    @Size(min = 1, message = "At least one course must be offered")
    private List<String> coursesOffered;

    @Email(message = "Invalid email format")
    private String contactEmail;

    @NotBlank(message = "Contact Phone is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact Phone must be exactly 10 digits")
    private String contactPhone;
}
