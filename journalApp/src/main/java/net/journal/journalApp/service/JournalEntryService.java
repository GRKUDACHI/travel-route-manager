package net.journal.journalApp.service;

import net.journal.journalApp.entity.journalEntry;
import net.journal.journalApp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class JournalEntryService
{
   @Autowired
    private JournalEntryRepository JournalEntryRepository;

   public void saveEntry(journalEntry journalEntry)
   {
       JournalEntryRepository.save(journalEntry);
   }

   public List<journalEntry> getAll()
   {
       return JournalEntryRepository.findAll();
   }

   public Optional<journalEntry> findById(long id)
   {
       return JournalEntryRepository.findById(id);
   }

   public void deleteById(long id)
   {
       JournalEntryRepository.deleteById(id);
   }
}
