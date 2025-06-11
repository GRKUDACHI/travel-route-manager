package net.journal.journalApp.controller;

import net.journal.journalApp.entity.journalEntry;
import net.journal.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController
{
   @Autowired
   private JournalEntryService JournalEntryService;

    @GetMapping
    public List<journalEntry> getAll()
    {
        return JournalEntryService.getAll();
    }

    @PostMapping
    public boolean createEntry(@RequestBody journalEntry myEntry)
    {

        JournalEntryService.saveEntry(myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public  journalEntry getjournalEntryById(@PathVariable Long myId)
    {
        return JournalEntryService.findById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean deletejournalEntryById(@PathVariable Long myId)
    {
        JournalEntryService.deleteById(myId);
        return true;
    }

    @PutMapping("id/{Id}")
    public journalEntry updatejournalEntryById(@PathVariable Long Id, @RequestBody journalEntry newEntry)
    {
        journalEntry old = JournalEntryService.findById(Id).orElse(null);

        if(old != null)
        {
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle(): old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent(): old.getContent());

        }

        JournalEntryService.saveEntry(old);
        return old;
    }
}
