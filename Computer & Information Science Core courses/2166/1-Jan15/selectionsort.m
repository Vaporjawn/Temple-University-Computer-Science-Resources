function x = selectionsort(x)
%--------------------------------------------------------------------------
% Syntax:       sx = selectionsort(x);
%               
% Inputs:       x is a vector of length n
%               
% Outputs:      sx is the sorted (ascending) version of x
%               
% Description:  This function sorts the input array x in ascending order
%               using the selection sort algorithm
%               
% Complexity:   O(n^2)    best-case performance
%               O(n^2)    average-case performance
%               O(n^2)    worst-case performance
%               O(1)      auxiliary space
%               
% Author:       Brian Moore
%               brimoor@umich.edu
%               
% Date:         January 5, 2014
%--------------------------------------------------------------------------

% Seletion sort
n = length(x);
for j = 1:(n - 1)
    % Find jth smallest element
    imin = j;
    for i = (j + 1):n
        if (x(i) < x(imin))
            imin = i;
        end
    end
    
    % Put jth smallest element in place
    if (imin ~= j)
        x = swap(x,imin,j);
    end
end

end

function x = swap(x,i,j)
% Swap x(i) and x(j)
% Note: In practice, x xhould be passed by reference

val = x(i);
x(i) = x(j);
x(j) = val;

end