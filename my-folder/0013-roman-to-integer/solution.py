class Solution:
    def romanToInt(self, s: str) -> int:
        roman_to_int_map = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000
        }
        
        start = len(s) - 1
        result = 0
        for i in range(len(s) - 1, -1, -1):
            if (i == len(s) - 1):
                result += roman_to_int_map[s[i]]
            elif (roman_to_int_map[s[i]] >= roman_to_int_map[s[i+1]]):
                result += roman_to_int_map[s[i]]
            else:
                result -= roman_to_int_map[s[i]]
        
        return result
