class Solution {
    Map<String, Integer> dp = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    return f(price, special, needs, 0);    
    }

    private int direct_purchase(List<Integer> price, List<Integer> needs){
        int total = 0;
        for(int i = 0; i < needs.size(); i++){
            total += price.get(i) * needs.get(i);
        }
        return total;
    }

    private boolean is_valid(List<Integer> offer, List<Integer> needs){
        for(int i = 0; i < needs.size(); i++){
            if(needs.get(i) < offer.get(i)) {
                return false;
            }
        }
        return true;
    }

    int f(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int idx){
        String key = needs.toString() + idx;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        int res = direct_purchase(price, needs);

        for(int i = idx; i < special.size(); i++){
            List<Integer> offer = special.get(i);

            if(is_valid(offer, needs)){
                List<Integer> tempNeeds = new ArrayList<>();
                for(int j = 0; j < needs.size(); j++){
                tempNeeds.add(needs.get(j) - offer.get(j));
            }

            int offer_price = offer.get(offer.size() - 1);
            res = Math.min(res, offer_price + f(price, special, tempNeeds, idx));
        }
    }
    dp.put(key, res);
    return res;
}
}
