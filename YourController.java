// ...existing code...

@GetMapping("/res")
public ResponseEntity<CountryCity> stream(@RequestParam("prompt") String prompt) {
    CountryCity countryCity = chatClient.prompt(prompt).call().entity(CountryCity.class);
    return ResponseEntity.ok(countryCity);
}

// ...existing code...

