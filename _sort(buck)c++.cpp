#include <iostream>
#include <vector>
using namespace std;

void insertion_sort(vector<double>& bukt)
{
    for (int j = 1; j < bukt.size(); j++)
    {
        double val = bukt[j];
        int k = j - 1;

        while (k >= 0 && bukt[k] > val)
        {
            bukt[k + 1] = bukt[k];
            k--;
        }

        bukt[k + 1] = val;
    }
}

void bucket_sort(vector<double>& inputArr)
{
    int s = inputArr.size();

    vector<vector<double>> bucketArr(s);

    // Colocar cada elemento en su bucket
    for (double j : inputArr)
    {
        int b1 = (int)(s * j);

        if (b1 >= s)
        {
            b1 = s - 1;
        }

        bucketArr[b1].push_back(j);
    }

    // Ordenar cada bucket
    for (auto& bukt : bucketArr)
    {
        insertion_sort(bukt);
    }

    // Unir todos los buckets
    int idx = 0;

    for (auto& bukt : bucketArr)
    {
        for (double j : bukt)
        {
            inputArr[idx] = j;
            idx++;
        }
    }
}

int main()
{
    vector<double> inputArr = {
        0.77, 0.16, 0.38, 0.25, 0.71,
        0.93, 0.22, 0.11, 0.24, 0.67
    };

    cout << "Arreglo antes de ordenar:" << endl;

    for (double j : inputArr)
    {
        cout << j << " ";
    }

    cout << endl;

    bucket_sort(inputArr);

    cout << "Arreglo despues de ordenar:" << endl;

    for (double j : inputArr)
    {
        cout << j << " ";
    }

    cout << endl;

    return 0;
}
