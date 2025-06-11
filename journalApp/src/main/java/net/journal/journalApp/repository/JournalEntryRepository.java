package net.journal.journalApp.repository;

import net.journal.journalApp.entity.journalEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalEntryRepository extends JpaRepository<journalEntry, Long>
{

}
