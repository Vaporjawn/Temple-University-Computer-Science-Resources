function x = insertionsort(x)
n = length(x);
for j = 2:n
    current = x(j);
    i = j;
    while ((i > 1) && (x(i - 1) > current))
        x(i) = x(i - 1);
        i = i - 1;
    end
    x(i) = current;
end

end