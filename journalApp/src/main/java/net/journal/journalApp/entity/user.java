package net.journal.journalApp.entity;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Reference;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
public class user
{
    @Id
    private Long id;
    @NonNull
    private String userName;
    @NonNull
    private String Password;
    @Reference
    private List<journalEntry> journalEntryList = new ArrayList<>();
}
