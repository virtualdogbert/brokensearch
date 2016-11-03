// Place your Spring DSL code here
beans = {
    indexRequestQueue(brokensearch.IndexRequestQueue) {
        elasticSearchContextHolder = ref('elasticSearchContextHolder')
        elasticSearchClient = ref('elasticSearchClient')
        jsonDomainFactory = ref('jsonDomainFactory')
    }
}
