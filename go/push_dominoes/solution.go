package push_dominoes

func pushDominoes(dominoes string) string {
	temp := []byte(dominoes)
	prevC := byte('L')
	prevRIdx := -1
	for idx, c := range temp {
		if c == '.' {
			continue
		}
		if c == 'L' {
			if prevC == 'R' {
				for i, j := prevRIdx+1, idx-1; i < j; i, j = i+1, j-1 {
					temp[i] = 'R'
					temp[j] = 'L'
				}
				prevC = 'L'
			} else {
				for j := idx - 1; j >= 0 && temp[j] == '.'; j-- {
					temp[j] = 'L'
				}
			}
		} else {
			if prevC == 'R' {
				for i := prevRIdx + 1; temp[i] == '.'; i++ {
					temp[i] = 'R'
				}
			} else {
				prevC = 'R'
			}
			prevRIdx = idx
		}
	}
	if prevC == 'R' {
		for j := len(temp) - 1; temp[j] == '.'; j-- {
			temp[j] = 'R'
		}
	}
	return string(temp)
}
