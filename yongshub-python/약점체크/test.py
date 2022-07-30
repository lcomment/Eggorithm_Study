def compressWord(word, k):
    compressed = ''
    splited = [word[i:i + k] for i in range(0, len(word))]
        
    for split in splited:
        split = list(split)
        start = split[0]
        if split.count(start) != k:
            if len(compressed) > 0:
                compressed = compressed[0: len(compressed) - 1]
            compressed += ''.join(split[1:])
    if len(compressed) < len(word):
        compressed = compressWord(compressed, k)
    return compressed


result = compressWord('baac', 2)