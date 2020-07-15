function x = bubblesort(x)
% implementation of bubble sort as in Rosen's book
n = length(x);
for i = 1:n-1  %number of passes
    for j = 1:n-i
        % Swap elements if they are in wrong order
        if (x(j) > x(j + 1))
            x = swap(x,j,j + 1);
        end
    end
    fprintf('Pass %i: \n', i)
    fprintf('\t%d ', x)
    fprintf('\n\n')
end

end

function x = swap(x,i,j)
% Swap x(i) and x(j)
% Note: In practice, x xhould be passed by reference

val = x(i);
x(i) = x(j);
x(j) = val;

end