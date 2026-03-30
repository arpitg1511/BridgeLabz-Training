class PlusOne {
    public int[] plusOne(int[] digits) {
        List<Integer> ll = new ArrayList<>();

        int cy = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + 1;
            if(sum >= 10) {
                sum = sum - 10;
                cy = 1;
            }
            else cy = 0;

            digits[i] = sum;
            if(cy == 0) return digits;
            ll.add(sum);
        }

        if(cy != 0) ll.add(cy);

        int[] ans = new int[ll.size()];

        for(int i = ll.size() - 1; i >= 0; i--) {
            ans[i] = ll.get(ll.size() - 1 - i);
        }

        return ans;
    }
}