package org.BatiCuisine.Service;

import org.BatiCuisine.Model.Quote;
import org.BatiCuisine.Repository.Interfaces.QuoteRepository;

import java.util.*;
import java.util.stream.Collectors;

public class QuoteService {

    private final QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public void addQuote(Quote quote) {
        quoteRepository.addQuote(quote);
    }

    public void updateQuote(Quote quote) {
        quoteRepository.updateQuote(quote);
    }

    public Optional<Quote> getQuoteByProjectID(UUID quoteId) {
        return quoteRepository.getQuoteByProjectID(quoteId);
    }

    public Map<UUID, Double> getTotalCost(List<Quote> quotes){
        Map<UUID, Double> quotesHashMap = new HashMap<>();
        for (Quote quote: quotes){
            quotesHashMap.put(quote.getProject().getClient().getClientID(), quote.getEstimatedAmount());
        }
        return quotes.stream().collect(Collectors.toMap(
                quote -> quote.getProject().getClient().getClientID() ,
                quote -> quote.getEstimatedAmount()
        ));

    }
}
